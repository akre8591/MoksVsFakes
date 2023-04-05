class UserRepositoryImp(
    private val api: UserApi
) : UserRepository {

    override fun getUserInformation(userId: Int): User? {
        return api.fetchUserById(userId = userId)
    }

}