package com.fathansatria.pagination3sample.networks

import android.util.Log
import com.fathansatria.pagination3sample.utils.*
import retrofit2.Response
import java.net.SocketTimeoutException

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T? {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()
        } else {
            Log.i("Error code :", " ${response.code()}")
            when (response.code()) {
                400 -> throw BusinessException(response.errorBody())
                401 -> throw UnauthorizedException()
                403 -> throw ForbiddenException()
                404 -> throw NotFoundException()
                422 -> throw BusinessException(response.errorBody())
                500 -> throw ServerErrorException()
                502 -> throw BadGatewayException()
            }
            throw SocketTimeoutException()
        }
    }

}


