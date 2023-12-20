package com.example.kerjaparaktik.home
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.example.kerjaparaktik.R

class ChatbotFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chatbot, container, false)

        val webView: WebView = view.findViewById(R.id.webView)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // URL chatbot Watson Assistant
        val chatbotUrl = "https://novaazzahra4.github.io/chatbot_website/"

        // Load URL chatbot
        webView.loadUrl(chatbotUrl)
        return view
    }
}
