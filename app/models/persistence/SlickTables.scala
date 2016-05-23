package models.persistence

import models.entities.{ParkingSlot, User}
import play.api.Play
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfig}
import slick.driver.JdbcProfile

/**
  * The companion object.
  */
object SlickTables extends HasDatabaseConfig[JdbcProfile] {

  protected lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
  import dbConfig.driver.api._

  abstract class BaseTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  }

  //  case class SimpleSupplier(name: String, desc: String)

  class UsersTable(tag: Tag) extends BaseTable[User](tag, "users") {
    def login = column[String]("login")

    def * = (id, login) <>(User.tupled, User.unapply)
  }

  class ParkingSlotTable(tag: Tag) extends BaseTable[ParkingSlot](tag, "parking_slot") {
    def lat = column[Double]("lat")

    def lon = column[Double]("lon")

    def freeFrom = column[String]("free_from")

    def userId = column[Long]("user_id")

    def * = (id, lat, lon, freeFrom, userId) <> (ParkingSlot.tupled, ParkingSlot.unapply _)
  }

  val usersTableQ: TableQuery[UsersTable] = TableQuery[UsersTable]
  val parkingSlotTableQ: TableQuery[ParkingSlotTable] = TableQuery[ParkingSlotTable]

}
