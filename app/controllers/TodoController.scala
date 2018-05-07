package controllers

import javax.inject._
import play.api.mvc._
import services._

import play.api.data._
import play.api.data.Forms._

import play.api.data.validation.Constraints._

import play.api.i18n.I18nSupport


class TodoController @Inject() (todoService: TodoService) extends Controller {
  def list() = Action {
    val items: Seq[Todo] = todoService.list()
    Ok(views.html.list(items))
  }
  val todoForm: Form[String] = Form("name" -> nonEmptyText)


  def todoNew = Action { implicit request =>
    Ok(views.html.createForm(todoForm))
  }

  def todoAdd = Action { implicit request =>
    val name: String = todoForm.bindFromRequest.get
    println(name)
    Ok("Save")
  }
}
