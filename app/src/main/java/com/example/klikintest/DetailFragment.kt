import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.klikintest.R


class DetailFragment : Fragment() {
    private lateinit var mview: View



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mview = inflater.inflate(R.layout.fragment_detail, container, false)

        val itemId= arguments?.getString(ITEM_ID)
        setupView()
        return mview
    }
    private fun setupView() {

        }
}


