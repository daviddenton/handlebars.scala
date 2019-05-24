package com.gilt.handlebars.scala.logging

import slogging.LoggerFactory

trait Loggable {
  protected final val loggerName: String = getClass.getName
  lazy val logger = LoggerFactory.getLogger(getClass.getName)

  def debug(message: String, t: Any*) = logger.debug(message, t)

  def debug(message: String, t: Throwable) = logger.debug(message, t)

  def info(message: String, t: Any*) = logger.info(message, t)

  def info(message: String, t: Throwable) = logger.info(message, t)

  def warn(message: String, t: Any*) = logger.warn(message, t)

  def warn(message: String, t: Throwable) = logger.warn(message, t)

  def error(message: String, t: Any*) = logger.error(message, t)

  def error(message: String, t: Throwable) = logger.error(message, t)
}
