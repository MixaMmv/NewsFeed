package com.example.newsfeedapp

import com.example.newsfeedapp.base.Either


inline fun <reified T> attempt(func: () -> T): Either<Throwable, T> = try {
    Either.Right(func.invoke())
} catch (e: Throwable) {
    Either.Left(e)
}