package fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import com.facebook.CallbackManager
import com.sample.testanalytics.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by Nguyen on 2019-08-16
 */
class HomeFragment : Fragment() {

    private val callbackManager: CallbackManager = CallbackManager.Factory.create()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.webChromeClient = WebChromeClient()
        webView.loadUrl("file:///android_asset/privacy_policy.html")
    }
}
