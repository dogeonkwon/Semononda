package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.User;
import com.ssafy.db.qentity.QBoard;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class BoardRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QBoard qBoard = QBoard.board;
    
<<<<<<< HEAD
    public Board findBoardByUid(int uid) {
        Board board = jpaQueryFactory.select(qBoard).from(qBoard)
                .where(qBoard.uid.eq(uid)).fetchOne();
        return board;
=======
    public Optional<Board> findBoardByUid(int uid) {
        Board board = jpaQueryFactory.select(qBoard).from(qBoard)
                .where(qBoard.uid.eq(uid)).fetchOne();
        if(board == null) return Optional.empty();
        return Optional.ofNullable(board);
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
    }
}
