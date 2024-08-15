class FakeUserApi : UserApi {

    var user: User? = null

    override fun fetchUserById(userId: Int): User? {
        return user
    }
}