package io.social.socialcommunity.domain.categoryinterest.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.category.domain.CategoryType
import io.social.socialcommunity.domain.user.domain.User
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CategoryInterestTest {
	lateinit var user: User
	lateinit var category: Category

	@BeforeEach
	fun userSetting() {
		this.user = User("Maeve", "maeve0312", "서초구 잠원동")
		val name = "동네질문"
		this.category = Category(CategoryType.BASIC, name)
	}

	@Test
	fun `BASIC 타입의 카테고리는 관심여부를 생성할 수 없다`() {
		val name = "동네질문"
		val category = Category(CategoryType.BASIC, name)

		Assertions.assertThatThrownBy { CategoryInterest.create(category, user) }
			.isInstanceOf(IllegalArgumentException::class.java)
	}

	@Test
	fun `BASIC 타입의 카테고리가 아니면 관심여부를 수정할 수 있다`() {
		val name = "동네맛집"
		val category = Category(CategoryType.INTEREST, name)

		val categoryInterest = CategoryInterest.create(category, user)

		Assertions.assertThat(categoryInterest.category).isEqualTo(category)
		Assertions.assertThat(categoryInterest.user).isEqualTo(user)
	}
}