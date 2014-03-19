//
//  mycustomevent.cpp
//  MyGame
//
//  Created by zhuang hua on 14-3-16.
//
//

#include "mycustomevent.h"
#include "cocos2d.h"
void mycustomevent()
{
    printf("mycustomevent");
    static int count = 0;
    ++count;
    char* buf = new char[10];
    sprintf(buf, "%d", count);
    cocos2d::EventCustom event("game_custom_event1");
    event.setUserData(buf);
    cocos2d::Node* rootNode = (cocos2d::Node*)cocos2d::Director::getInstance()->getRunningScene();
    rootNode->getEventDispatcher()->dispatchEvent(&event);
//    rootNode->EventDispatcher(&event);
    //cocos2d::EventDispatcher::getInstance()->dispatchEvent(&event);
    
 //   _eventDispatcher->dispatchEvent(&event);
    CC_SAFE_DELETE_ARRAY(buf);
}
void sendtouchbegin(int id, float x, float y)
{
    int  ids[1] = {0};
    float xs[1] = {0.0f};
    float ys[1] = {0.0f};
    
    int i = 0;
    /*
    for (UITouch *touch in touches) {
        ids[i] = touch;
        xs[i] = [touch locationInView: [touch view]].x * self.contentScaleFactor;;
        ys[i] = [touch locationInView: [touch view]].y * self.contentScaleFactor;;
        NSLog(@"touchBegin xs=%f,ys=%f ids=%d",xs[i],ys[i],((int*)ids)[i]);
        
        ++i;
        
    }
     */
    ids[0]= id;
    xs[0]=x;
    ys[0]=y;
    
    auto glview = cocos2d::Director::getInstance()->getOpenGLView();
    glview->handleTouchesBegin(1, (int*)ids, xs, ys);
    
}
void sendtouchmove(int id, float x, float y)
{
    int  ids[1] = {0};
    float xs[1] = {0.0f};
    float ys[1] = {0.0f};
    
    int i = 0;
    /*
     for (UITouch *touch in touches) {
     ids[i] = touch;
     xs[i] = [touch locationInView: [touch view]].x * self.contentScaleFactor;;
     ys[i] = [touch locationInView: [touch view]].y * self.contentScaleFactor;;
     NSLog(@"touchBegin xs=%f,ys=%f ids=%d",xs[i],ys[i],((int*)ids)[i]);
     
     ++i;
     
     }
     */
    ids[0]= id;
    xs[0]=x;
    ys[0]=y;
    
    auto glview = cocos2d::Director::getInstance()->getOpenGLView();
    glview->handleTouchesMove(1, (int*)ids, xs, ys);
    
}
void sendtouchend(int id, float x, float y)
{
    int  ids[1] = {0};
    float xs[1] = {0.0f};
    float ys[1] = {0.0f};
    
    int i = 0;
    /*
     for (UITouch *touch in touches) {
     ids[i] = touch;
     xs[i] = [touch locationInView: [touch view]].x * self.contentScaleFactor;;
     ys[i] = [touch locationInView: [touch view]].y * self.contentScaleFactor;;
     NSLog(@"touchBegin xs=%f,ys=%f ids=%d",xs[i],ys[i],((int*)ids)[i]);
     
     ++i;
     
     }
     */
    ids[0]= id;
    xs[0]=x;
    ys[0]=y;
    
    auto glview = cocos2d::Director::getInstance()->getOpenGLView();
    glview->handleTouchesEnd(1, (int*)ids, xs, ys);
    
}