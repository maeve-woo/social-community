package io.social.socialcommunity.domain.support.jpa

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity(
	@Id @GeneratedValue
	var id: Long? = null,

	) : Serializable {
	fun get(): Long {
		return id!!
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other !is BaseEntity) return false

		if (id != other.id) return false

		return true
	}

	override fun hashCode(): Int {
		return id?.hashCode() ?: 0
	}
}