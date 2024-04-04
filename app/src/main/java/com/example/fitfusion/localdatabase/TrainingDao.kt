import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fitfusion.localdatabase.Training
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingDao {
    @Insert
    suspend fun insert(training: Training)

    @Query("SELECT * FROM training")
    fun getAllTrainings(): Flow<List<Training>>
}