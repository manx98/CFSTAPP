package com.cfst.app.speedtest

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DownloadTestTest {
    @Test
    fun normalizesAndRejectsUnsafeDownloadUrls() {
        assertEquals(DownloadTest.DEFAULT_DOWNLOAD_URL, DownloadTest.normalizeDownloadUrl("  "))
        assertEquals("https://example.com:8443/file?token=abc", DownloadTest.normalizeDownloadUrl(" https://example.com:8443/file?token=abc#ignored "))
        assertNull(DownloadTest.normalizeDownloadUrl("ftp://example.com/file"))
        assertNull(DownloadTest.normalizeDownloadUrl("https://user:pass@example.com/file"))
        assertNull(DownloadTest.normalizeDownloadUrl("https://1.1.1.1/file"))
        assertNull(DownloadTest.normalizeDownloadUrl("https://[2606:4700::1]/file"))
    }
}
