package models.entities

case class ParkingSlot(
                        id: Long,
                        lat: Double,
                        lon: Double,
                        freeFrom: java.sql.Timestamp,
                        userId: Long
                        ) extends BaseEntity

object ParkingSlot extends ((Long, Double, Double, java.sql.Timestamp, Long) => ParkingSlot) {
  ParkingSlot.tupled
}
