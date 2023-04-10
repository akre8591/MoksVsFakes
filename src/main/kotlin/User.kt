data class User(
    val id: Int,
    val name: String?,
    val lastName: String?,
    val age: Int?,
    val gender: Gender?
) {
    val infoIsComplete get() = name != null && lastName != null && age != null && gender != null
}

enum class Gender(val pronoun: String) {
    Female("She/Her"),
    Male("He/Him")
}
