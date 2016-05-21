package models.entities

case class User(id: Long, login: String) extends BaseEntity

object User extends ((Long, String) => User) {
  User.tupled
}

