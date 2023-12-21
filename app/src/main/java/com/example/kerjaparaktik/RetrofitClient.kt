import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

<<<<<<< HEAD
    private const val BASE_URL = "http://192.168.1.2/app_mobile/"
=======
    private const val BASE_URL = "http://192.168.249.74/app_mobile/"
>>>>>>> 21880908bc2895b4742cbf8dda5c1969db6f2e2d
    private var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .build()
        }
        return retrofit!!
    }
}
