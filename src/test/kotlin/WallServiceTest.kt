import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun addTest() {
        val service = WallService()
        val likes = Likes(
            count = 50,
            userLikes = false,
            canLike = true,
            canPublish = true
        )
        val postTest = service.add(Post(id = 0, likes = likes))
        val result = postTest.id > 0

        assertTrue(result)
    }

    @Test
    fun updateTestTrue() {
        val service = WallService()
        val likes = Likes(
            count = 50,
            userLikes = false,
            canLike = true,
            canPublish = true
        )

        service.add(Post(id = 0, likes = likes))
        service.add(Post(id = 0, likes = likes))
        service.add(Post(id = 0, likes = likes))

        val update = Post(id = 3, likes = likes)

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateTestFalse() {
        val service = WallService()
        val likes = Likes(
            count = 50,
            userLikes = false,
            canLike = true,
            canPublish = true
        )

        service.add(Post(id = 0, likes = likes))
        service.add(Post(id = 0, likes = likes))
        service.add(Post(id = 0, likes = likes))

        val update = Post(id = 5, likes = likes)

        val result = service.update(update)

        assertFalse(result)
    }
}