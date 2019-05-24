package com.gilt.handlebars.scala.partial

import org.scalatest.{ FunSpec, Matchers }
import com.gilt.handlebars.scala.parser._
import scala.io.Source
import java.io.File
import com.gilt.handlebars.scala.binding.dynamic._

/**
 * User: chicks
 * Date: 7/1/13
 * Time: 11:22 AM
 */
class PartialHelperSpec extends FunSpec with Matchers {
  import PartialHelper._
  describe("filterPartials") {
    it("filters partials out of a simple template") {
      val program = HandlebarsGrammar("{{> myPartial}}").get
      val expected = List(Partial(PartialName(Identifier(List("myPartial"))),None))

      filterPartials(program) should equal(expected)
    }

    it("filters partials out of a complex template") {
      val template = Source.fromFile("jvm/src/test/resources/partialParse.handlebars").mkString
      val program = HandlebarsGrammar(template).get
      val expected = Set(
        Partial(PartialName(Identifier(List("localPartial"))),None),
        Partial(PartialName(Identifier(List("partials", "aPartial"))),None),
        Partial(PartialName(Identifier(List("filetest"))),None)
      )
      filterPartials(program).toSet should equal(expected)
    }
  }

  describe("findPartials") {
    it("finds partial in a file") {
      val partials = findAllPartials(new File("jvm/src/test/resources/filetest.handlebars"))
      val expected = Map(
        "localPartial" -> "jvm/src/test/resources/localPartial.handlebars",
        "partials/aPartial" -> "jvm/src/test/resources/partials/aPartial.handlebars",
        "partialWithinAPartial" -> "jvm/src/test/resources/partials/partialWithinAPartial.handlebars"
      )
      val actual = partials.mapValues(_.getPath)

      actual should equal(expected)
    }

    it("recursively finds partials in a file") {
      val partials = findAllPartials(new File("jvm/src/test/resources/intermediate.handlebars"))
      val expected = Map(
        "somethingElse" -> "jvm/src/test/resources/somethingElse.handlebars",
        "person" -> "jvm/src/test/resources/person.handlebars",
        "intermediate" -> "jvm/src/test/resources/intermediate.handlebars"
      )
      val actual = partials.mapValues(_.getPath)

      actual should equal(expected)
    }
  }
}
