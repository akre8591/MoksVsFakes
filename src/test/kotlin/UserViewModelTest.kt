import Constants.INCOMPLETE_INFORMATION_ERROR
import Constants.NO_RESULTS_ERROR
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class UserViewModelTest {

    private lateinit var userViewModel: UserViewModel
    private lateinit var fakeRepository: FakeUserRepository

    @Before
    fun setup() {
        fakeRepository = FakeUserRepository()
        userViewModel = UserViewModel(fakeRepository)
    }

    @Test
    fun getAllUserInfo() {
        val expectedResult = "Id: 1230\n" + "Name: Diego\n" + "Last Name: Casas\n" + "Gender: Male\n" + "Pronoun: He/Him\n" + "Age: 32"

        fakeRepository.user = User(1230, "Diego", "Casas",32, Gender.Male)

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoIsNull() {
        fakeRepository.user = null

        val expectedResult = NO_RESULTS_ERROR

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoNameIsNull() {
        fakeRepository.user = User(1230, null, "Casas",32, Gender.Male)

        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoLastNameIsNull() {
        fakeRepository.user = User(1230, "Diego", null,32, Gender.Male)

        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoAgeIsNull() {
        fakeRepository.user = User(1230, "Diego", "Casas",null, Gender.Male)

        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

    @Test
    fun getAllUserInfoGenreIsNull() {
        fakeRepository.user = User(1230, "Diego", "Casas",32, null)

        val expectedResult = INCOMPLETE_INFORMATION_ERROR

        val actual = userViewModel.getAllUserInformation(1230)

        assertEquals(expectedResult, actual)
    }

}