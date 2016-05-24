import java.time.Clock

import com.google.inject.{AbstractModule, Provides}
import models.daos.{AbstractBaseDAO, BaseDAO}
import models.entities.{ParkingSlot, User}
import models.persistence.SlickTables
import models.persistence.SlickTables.{ParkingSlotTable, UsersTable}


/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.

 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
class Module extends AbstractModule {

  override def configure() = {
    // Use the system clock as the default implementation of Clock
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
  }

  @Provides
  def provideUsersDAO: AbstractBaseDAO[UsersTable, User] = new BaseDAO[UsersTable, User] {
    override protected val tableQ: dbConfig.driver.api.TableQuery[UsersTable] = SlickTables.usersTableQ
  }

  @Provides
  def provideParkingSlotDAO: AbstractBaseDAO[ParkingSlotTable, ParkingSlot] = new BaseDAO[ParkingSlotTable, ParkingSlot] {
    override protected val tableQ: dbConfig.driver.api.TableQuery[ParkingSlotTable] = SlickTables.parkingSlotTableQ
  }

}



