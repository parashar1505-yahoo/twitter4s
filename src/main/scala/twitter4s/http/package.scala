package twitter4s

import java.net.{URLDecoder, URLEncoder}

import spray.http.Uri

package object http {

  implicit class RichString(val value: String) {

    def toAscii = urlEncoded.replace("+", "%20")

    def urlEncoded = URLEncoder.encode(value, "UTF-8")

    def urlDecoded = URLDecoder.decode(value, "UTF-8")

  }

  implicit class RichUri(val uri: Uri) {

    def endpoint = s"${uri.scheme}:${uri.authority}${uri.path}"
  }
}
