import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fitfusion.localdatabase.Training
import com.example.fitfusion.localdatabase.usuarios.User
import com.example.fitfusion.localdatabase.usuarios.UserDao

@Database(entities = [Training::class], version = 1)
abstract class TrainingDatabase : RoomDatabase() {
    abstract fun trainingDao(): TrainingDao
}