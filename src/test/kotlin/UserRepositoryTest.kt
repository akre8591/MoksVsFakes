import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Before
import org.junit.Test

class UserRepositoryTest {

    private lateinit var sut: UserRepositoryImp
    private val userApi = FakeUserApi()

    @Before
    fun setup() {
        sut = UserRepositoryImp(userApi)
    }

    @Test
    fun getValidUserFromApi() {
        val expectedResult = User(id = 12, name = "Diego", lastName = "Casas", age = 34, gender = Gender.Male)
        userApi.user = expectedResult

        val actual = sut.getUserInformation(userId = 12)

        assertEquals(actual, expectedResult)
    }

    @Test
    fun getInvalidUserFromApi() {
        val actual = sut.getUserInformation(userId = 12)

        assertNull(actual)
    }
}