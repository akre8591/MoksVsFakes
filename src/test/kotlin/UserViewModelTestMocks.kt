import Constants.INCOMPLETE_INFORMATION_ERROR
import Constants.NO_RESULTS_ERROR
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import junit.framework.TestCase.assertEquals

class UserViewModelTestMocks {

    private lateinit var userViewModel: UserViewModel
    private val repository: UserRepository = mockk(relaxed = true)

    @Before
    fun setup() {
        userViewModel = UserViewModel(repository)
    }

    @Test
    fun getAllUserInfo() {
        val expectedResult = "Id: 1230\n" + "Name: Diego\n" + "Last Name: Casas\n" + "Gender: Male\n" + "Pronoun: He/Him\n" + "Age: 32"

        every {
            repository.getUserInformation(1230)
        } returns User(1230, "Diego", "Casas", 32, Gender.Male)

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoIsNull() {
        val expectedResult = NO_RESULTS_ERROR

        every {
            repository.getUserInformation(1230)
        } returns null

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoNameIsNull() {
        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        every {
            repository.getUserInformation(1230)
        } returns User(1230, null, "Casas", 32, Gender.Male)

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoLastNameIsNull() {
        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        every {
            repository.getUserInformation(1230)
        } returns User(1230, "Diego", null, 32, Gender.Male)

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoAgeIsNull() {
        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        every {
            repository.getUserInformation(1230)
        } returns User(1230, "Diego", "Casas", null, Gender.Male)

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoGenreIsNull() {
        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        every {
            repository.getUserInformation(1230)
        } returns User(1230, "Diego", "Casas", 32, null)

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

}