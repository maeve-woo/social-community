package io.social.socialcommunity.domain.post.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.category.domain.CategoryType
import io.social.socialcommunity.domain.user.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PostTest {
	lateinit var user: User
	lateinit var category: Category

	@BeforeEach
	fun userSetting() {
		this.user = User("Maeve", "maeve0312", "서초구 잠원동")
		val name = "동네질문"
		this.category = Category(CategoryType.BASIC, name)
	}

	@Test
	fun `게시글 생성`() {
		val post = Post(category, user, "붕어빵 좌표쫌 주세요.")

		assertThat(post.writer).isEqualTo(user)
		assertThat(post.category).isEqualTo(category)
	}
}