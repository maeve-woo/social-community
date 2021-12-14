package io.social.socialcommunity.domain.category.domain

import io.social.socialcommunity.domain.user.domain.User
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
		val category = Category(CategoryType.BASIC, name, user)

		assertThat(category.type).isEqualTo(CategoryType.BASIC)
		assertThat(category.name).isEqualTo(name)
		assertThat(category.isInterest).isTrue

		val name2 = "동네맛집"
		val category2 = Category(CategoryType.INTEREST, name2, user)

		assertThat(category2.type).isEqualTo(CategoryType.INTEREST)
		assertThat(category2.name).isEqualTo(name2)
		assertThat(category2.isInterest).isTrue
	}

	@Test
	fun `BASIC 타입의 카테고리는 관심여부를 수정할 수 없다`() {
		val name = "동네질문"
		val category = Category(CategoryType.BASIC, name, user)

		assertThat(category.isInterest).isTrue
		assertThatThrownBy { category.uninterest() }
			.isInstanceOf(IllegalArgumentException::class.java)
	}

	@Test
	fun `BASIC 타입의 카테고리가 아니면 관심여부를 수정할 수 있다`() {
		val name = "동네맛집"
		val category = Category(CategoryType.INTEREST, name, user)

		assertThat(category.isInterest).isTrue
		category.uninterest()
		assertThat(category.isInterest).isFalse
		category.interest()
		assertThat(category.isInterest).isTrue
	}
}