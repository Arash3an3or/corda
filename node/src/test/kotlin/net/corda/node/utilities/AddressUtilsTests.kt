package net.corda.node.utilities

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AddressUtilsTests {
    @Test(timeout=300_000)
	fun `correctly determines if the provided address is public`() {
        assertFalse { AddressUtils.isPublic("localhost") }
        assertFalse { AddressUtils.isPublic("127.0.0.1") }
        assertFalse { AddressUtils.isPublic("::1") }
        assertFalse { AddressUtils.isPublic("0.0.0.0") }
        assertFalse { AddressUtils.isPublic("::") }
        assertFalse { AddressUtils.isPublic("10.0.0.0") }
        assertFalse { AddressUtils.isPublic("10.255.255.255") }
        assertFalse { AddressUtils.isPublic("192.168.0.10") }
        assertFalse { AddressUtils.isPublic("192.168.255.255") }
        assertFalse { AddressUtils.isPublic("172.16.0.0") }
        assertFalse { AddressUtils.isPublic("172.31.255.255") }

        assertTrue { AddressUtils.isPublic("172.32.0.0") }
        assertTrue { AddressUtils.isPublic("192.169.0.0") }
        assertTrue { AddressUtils.isPublic("11.0.0.0") }
        assertTrue { AddressUtils.isPublic("corda.net") }
        assertTrue { AddressUtils.isPublic("2607:f298:5:110f::eef:8729") }
    }
}
