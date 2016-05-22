import org.scalatest.{FlatSpec, ShouldMatchers}

/**
  * Created by knabe on 21.05.16.
  */
class GeoUtilSpec extends FlatSpec with ShouldMatchers {


  "GeoUtil" should "compute distance 0" in {
    GeoUtil.distanceInMeters(17, 43, 17, 43) shouldBe 0
  }

  it should "compute distance 498.4" in {
    val (bundeskanzleramtLat, bundeskanzleramtLon) = (52.5201628,13.3692701)
    val (reichstagLat, reichstagLon) = (52.5186202,13.3761871)
    GeoUtil.distanceInMeters(bundeskanzleramtLat, bundeskanzleramtLon, reichstagLat, reichstagLon) should be (498.45 +- 0.05)
  }


}
