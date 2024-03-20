import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

object DatabaseManager {
    private const val url = "jdbc:sqlite:test.db"

    fun getConnection(): Connection {
        return DriverManager.getConnection(url)
    }

    fun createTable() {
        val sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                email TEXT NOT NULL,
                password TEXT NOT NULL
            );
        """.trimIndent()

        try {
            getConnection().use { connection ->
                connection.createStatement().use { statement ->
                    statement.executeUpdate(sql)
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }
    }

    fun insertUser(name: String, email: String, password: String) {
        val sql = "INSERT INTO users(name, email, password) VALUES(?, ?, ?);"

        try {
            getConnection().use { connection ->
                connection.prepareStatement(sql).use { statement ->
                    statement.setString(1, name)
                    statement.setString(2, email)
                    statement.setString(3, password)
                    statement.executeUpdate()
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }
    }

    fun userExists(name: String, email: String): Boolean {
        val sql = "SELECT COUNT(*) AS count FROM users WHERE name = ? OR email = ?;"

        try {
            getConnection().use { connection ->
                connection.prepareStatement(sql).use { statement ->
                    statement.setString(1, name)
                    statement.setString(2, email)
                    statement.executeQuery().use { resultSet ->
                        return resultSet.getInt("count") > 0
                    }
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }
        return false
    }

    fun verifyLogin(name: String, password: String): Boolean {
        val sql = "SELECT * FROM users WHERE name = ? AND password = ?;"

        try {
            getConnection().use { connection ->
                connection.prepareStatement(sql).use { statement ->
                    statement.setString(1, name)
                    statement.setString(2, password)
                    val resultSet: ResultSet = statement.executeQuery()
                    return resultSet.next() // Si hay al menos una fila, las credenciales son válidas
                }
            }
        } catch (e: SQLException) {
            println(e.message)
        }
        return false
    }
}