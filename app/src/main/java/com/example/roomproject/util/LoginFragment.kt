package com.example.roomproject.util

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomproject.Database.AppDataBase
import com.example.roomproject.Entity.User
import com.example.roomproject.R
import com.example.roomproject.databinding.FragmentLoginBinding
import java.util.Locale

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private val appDataBase: AppDataBase by lazy {
        AppDataBase.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.toReg.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        binding.login.setOnClickListener {
            val login = binding.name.text.toString()
            val password = binding.pass.text.toString()
            val user: User
//            val bundle = Bundle()

            if (login != "" && password != "") {
                user = appDataBase.getUsersDao().getUser(login, password)
//                bundle.putSerializable("user", user)
                if (user.role.lowercase(Locale.ROOT) == "student") {
                    findNavController().navigate(
                        R.id.action_loginFragment_to_studentPageFragment,
//                        bundle
                    )
                    Log.d("AAA", user.user_id.toString())
                }
                if (user.role.lowercase(Locale.ROOT) == "teacher") {
                    findNavController().navigate(R.id.action_loginFragment_to_teacherPageFragment)
                }
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}