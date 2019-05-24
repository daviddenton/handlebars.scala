package com.gilt.handlebars.scala

import java.io.File
import com.gilt.handlebars.scala.binding.BindingFactory

abstract class HandlebarsCompat {
  def createBuilder[T](file: File)(implicit c: BindingFactory[T]): DefaultHandlebarsBuilder[T] = DefaultHandlebarsBuilder(file)

  def apply[T](file: File)(implicit c: BindingFactory[T]): Handlebars[T] = createBuilder(file).build
}
