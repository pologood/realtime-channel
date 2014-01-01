//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/retechretech/dev/workspace/realtime/realtime-channel/src/main/java/com/goodow/realtime/core/WebSocket.java
//
//  Created by retechretech.
//

#ifndef _ComGoodowRealtimeCoreWebSocket_H_
#define _ComGoodowRealtimeCoreWebSocket_H_

@protocol GDJsonObject;

#import "JreEmulation.h"

@protocol ComGoodowRealtimeCoreWebSocket_WebSocketHandler < NSObject, JavaObject >
- (void)onCloseWithGDJsonObject:(id<GDJsonObject>)reason;
- (void)onErrorWithNSString:(NSString *)error;
- (void)onMessageWithNSString:(NSString *)message;
- (void)onOpen;
@end

@protocol ComGoodowRealtimeCoreWebSocket < NSObject, JavaObject >
- (void)close;
- (void)sendWithNSString:(NSString *)data;
- (void)setListenWithComGoodowRealtimeCoreWebSocket_WebSocketHandler:(id<ComGoodowRealtimeCoreWebSocket_WebSocketHandler>)handler;
@end

@interface ComGoodowRealtimeCoreWebSocket : NSObject {
}
+ (id<ComGoodowRealtimeCoreWebSocket>)EMPTY;
@end

@interface ComGoodowRealtimeCoreWebSocket_$1 : NSObject < ComGoodowRealtimeCoreWebSocket > {
}

- (void)close;
- (void)sendWithNSString:(NSString *)data;
- (void)setListenWithComGoodowRealtimeCoreWebSocket_WebSocketHandler:(id<ComGoodowRealtimeCoreWebSocket_WebSocketHandler>)handler;
- (id)init;
@end

#endif // _ComGoodowRealtimeCoreWebSocket_H_
