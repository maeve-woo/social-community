package io.social.socialcommunity.domain.categoryempathy.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.category.domain.CategoryType
import io.social.socialcommunity.domain.user.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CategoryEmpathyTest {
	lateinit var user: User
	lateinit var category: Category

	@BeforeEach
	fun userSetting() {
		this.user = User("Maeve", "maeve0312", "서초구 잠원동")
		val name = "동네질문"
		this.category = Category(CategoryType.BASIC, name)
	}

	@Test
	fun `카테고리 공감 생성`() {
		val name = "궁금해요"
		val categoryEmpathy = CategoryEmpathy(category, name)

		assertThat(categoryEmpathy.name).isEqualTo(name)
	}
}