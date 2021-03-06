package com.fathansatria.pagination3sample.utils

import okhttp3.ResponseBody

class BusinessException(val body: ResponseBody?): Exception()
class BadGatewayException: Exception()
class NotFoundException: Exception()
class ForbiddenException: Exception()
class UnauthorizedException: Exception()
class ServerErrorException: Exception()