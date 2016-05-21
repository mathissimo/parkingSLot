package models.entities

case class ParkingSlot(
                        id: Long,
                        lat: Double,
                        lon: Double,
                        freeFrom: java.util.Date,
                        user: User
                        ) extends BaseEntity
