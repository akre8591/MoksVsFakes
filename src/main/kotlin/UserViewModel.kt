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
                    append("Age: ${user.age}")
                }
            }
            "Error: Incomplete Information"
        } ?: run {
            "No results"
        }
    }

}