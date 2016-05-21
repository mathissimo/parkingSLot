package models.entities

case class ParkingSlot(
                        id: Long,
                        lat: Double,
                        lon: Double,
                        freeFrom: String,
                        userId: Long
                        ) extends BaseEntity

object ParkingSlot extends ((Long, Double, Double, String, Long) => ParkingSlot) {
  ParkingSlot.tupled
}
