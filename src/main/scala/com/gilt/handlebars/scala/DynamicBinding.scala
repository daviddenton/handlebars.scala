package com.gilt.handlebars.scala

import com.gilt.handlebars.scala.binding.{Binding, BindingFactory}
import scala.language.implicitConversions

trait BindingPackage[T] {
  implicit def valueToBinding(v: T): Binding[T] = bindingFactory(v)
  implicit val bindingFactory: BindingFactory[T]
}