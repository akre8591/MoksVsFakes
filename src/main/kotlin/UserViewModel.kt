import Constants.INCOMPLETE_INFORMATION_ERROR
import Constants.NO_RESULTS_ERROR

class UserViewModel(
    private val repository: UserRepository,
) {

    fun getAllUserInformation(userId: Int): String {
        return repository.getUserInformation(userId = userId)?.let { user ->
            if (user.infoIsComplete) {
                return@let buildString {
                    append("Id: ${user.id}\n")
                    append("Name: ${user.name}\n")
                    append("Last Name: ${user.lastName}\n")
                    append("Gender: ${user.gender}\n")
                    append("Pronoun: ${user.gender?.pronoun}\n")
                    append("Age: ${user.age}")
                }
            }
            INCOMPLETE_INFORMATION_ERROR
        } ?: run {
            NO_RESULTS_ERROR
        }
    }

}