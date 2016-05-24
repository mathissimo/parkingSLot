package controllers

import javax.inject._

import models.daos.{AbstractBaseDAO, BaseDAO}
import models.entities.{User}
import models.persistence.SlickTables.UsersTable
import play.api.libs.json.{Json, Writes}
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UsersController @Inject()(usersDAO : AbstractBaseDAO[UsersTable,User])(implicit exec: ExecutionContext) extends Controller {

  implicit val userWrites = new Writes[User] {
    def writes(entity: User) = Json.obj(
      "id" -> entity.id,
      "login" -> entity.login
    )
  }

  def user(id : Long) = Action.async {
    usersDAO.findById(id) map { user => user.fold(NoContent)(user => Ok(Json.toJson(user))) }
  }

  def insertUser = Action.async(parse.json) {
    request => {
      {
        for {
          login <- (request.body \ "login").asOpt[String]
        } yield {
          usersDAO.insert(User(0, login)) map { n => Ok("Id of User Added : " + n) }
        }
      }.getOrElse(Future{BadRequest("Wrong json format")})
    }
  }

}
