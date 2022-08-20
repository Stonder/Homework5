data class Post(
    var id: Int,
    var fromId: Int = 1,
    val replyOwnerId: Int = 1,
    val replyPostId: Int = 1,
    var date: Int = 1,
    var text: String = "hello",
    var postType: String = "post",
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    var isFavorite: Boolean = true,
    var likes: Likes
)

class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

class WallService {
    private var posts = emptyArray<Post>()
    private var id = 0

    fun add(post: Post): Post {
        id++
        posts += post.copy(id = id)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (post.id == oldPost.id) {
                posts[index] = post.copy(id = oldPost.id, date = oldPost.date)
                return true
            }
        }
        return false
    }
}
