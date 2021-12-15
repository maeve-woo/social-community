package io.social.socialcommunity.domain.category.domain

import io.social.socialcommunity.domain.user.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CategoryTest {
	lateinit var user: User

	@BeforeEach
	fun userSetting() {
		this.user = User("Maeve", "maeve0312", "서초구 잠원동")
	}

	@Test
	fun `카테고리 생성`() {
		val name = "동네질문"
		val category = Category(CategoryType.BASIC, name)

		assertThat(category.type).isEqualTo(CategoryType.BASIC)
		assertThat(category.name).isEqualTo(name)

		val name2 = "동네맛집"
		val category2 = Category(CategoryType.INTEREST, name2)

		assertThat(category2.type).isEqualTo(CategoryType.INTEREST)
		assertThat(category2.name).isEqualTo(name2)
	}
}