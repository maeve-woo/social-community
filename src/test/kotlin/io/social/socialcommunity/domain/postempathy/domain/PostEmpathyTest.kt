package io.social.socialcommunity.domain.postempathy.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.category.domain.CategoryType
import io.social.socialcommunity.domain.post.domain.Post
import io.social.socialcommunity.domain.user.domain.User
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PostEmpathyTest {
	lateinit var user: User
	lateinit var category: Category
	lateinit var post: Post

	@BeforeEach
	fun userSetting() {
		this.user = User("Maeve", "maeve0312", "서초구 잠원동")
		val name = "동네질문"
		this.category = Category(CategoryType.BASIC, name)
		this.post = Post(category, user, "붕어빵 좌표쫌 주세요.")
	}

	@Test
	fun `게시글 공감하기`() {
		val postEmpathy = PostEmpathy(post, user)

		assertThat(postEmpathy.user).isEqualTo(user)
		assertThat(postEmpathy.post).isEqualTo(post)
	}
}