/**Offers geographic calculations*/
object GeoUtil {

  /**Returns the distance in meters on the earth surface from the point 1 to point 2.
    * Adapted from the accepted answer from http://stackoverflow.com/questions/837872/calculate-distance-in-meters-when-you-know-longitude-and-latitude-in-java
    * */
  def distanceInMeters(lat1: Double,
                       lng1: Double,
                       lat2: Double,
                       lng2: Double): Double = {
    val earthRadius = 6371000
    val dLat = Math.toRadians(lat2 - lat1)
    val dLng = Math.toRadians(lng2 - lng1)
    val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
      Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
        Math.sin(dLng / 2) *
        Math.sin(dLng / 2)
    val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
    val dist = (earthRadius * c).toDouble
    dist
  }

}
