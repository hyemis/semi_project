
# semi_project

## 프로젝트 소개

<p align="justify">
개인 실습 프로젝트로 게시판을 만들어보았다.
</p>

<br>

#### 기술 스택

<p align="justify">
운영 체제 - Mac OS <br>
IDE - 2020-03 (4.15.0)<br>
DBMS - Oracle 11gXE 11.2.0 DB - Sqldeveloper v17.2.0<br>
Server - Apache Tomcat 10.0<br>
Laguage - Java11, HTML5, CSS, javascript, jQuery 3.4.1
</p>
<br>



#### 메인화면
![메인]
<p align="justify">
  상위 헤더 - include로 추가, 드랍다운 메뉴, 로그인/로그아웃, 회원가입 버튼을 누를 시 해당 페이지로 이동 <br>
  게시판 카드 클릭 시 각 게시판으로 페이지 이동 <br>
</p>

#### 회원가입
![회원가입]
<p align="justify">
  아이디 중복 체크 <br>
  모든 정보 기입해야 회원 가입 가능 <br>
  회원 가입 성공 시 메인 페이지로 이동 <br>
</p>

#### 게시글 조회 
![게시글 조회]
<p align="justify">
  게시글 제목 클릭 시 링크로 게시글 상세 페이지로 이동 <br>
  게시글 상세 보기 후 조회수 증가 <br>
  로그인 한 회원에 한하여 게시글 등록 가능 <br>
  페이징 구현 <br>
</p>

#### 게시글 조회 
![게시글 조회]
<p align="justify">
  게시글 제목 클릭 시 링크로 게시글 상세 페이지로 이동 <br>
  게시글 상세 보기 후 조회수 증가 <br>
  로그인 한 회원에 한하여 게시글 등록, 수정 가능 <br>
  페이징 구현 <br>
</p>

#### 게시글 상세조회 
![게시글 상세조회]
<p align="justify">
  게시글 제목 클릭 시 링크로 게시글 상세 페이지로 이동 <br>
  로그인 한 회원에 한하여 게시글 수정 가능 <br>
  비로그인 사용자는 댓글 조회 가능, 로그인 한 회원은 댓글 작성, 삭제 가능 <br>
</p>

#### 내 정보 조회 
![내정보 조회]
<p align="justify">
  내 정보 조회를 위해서 비밀번호 재확인 필요 <br>
  내 정보 수정 가능 <br>
  로그인 하지 않은 사용자가 URL로 접근 시 alert 창으로 알림 <br>
</p>


## 배운 점 & 아쉬운 점

<p align="justify">
  충분한 시간적 여유가 없어 모든 UI, 기능들을 다 구현하지 못해서 아쉬웠지만 Servlet/JSP, MVC2 모델의 구조를 이해할 수 있는 시간이 되었고, JQuery, Ajax 등의 기술에 적응할 수 있었습니다. 또한 테이블 간의 관계 설정을 중요성을 깨달았습니다. 다음 프로젝트를 진행하게 된다면 DB 설계부터 더욱 철저히 계획을 세워 많은 기능을 구현할 수 있을 것이라고 생각합니다.  <br>
</p>

<!-- Stack Icon Refernces -->

[js]: image/stack/javascript.svg
[css]: image/stack/css.svg
[html]: image/stack/html.svg
[java]: image/stack/java.png
[oracle]: image/stack/oracle.png



<!-- Sample Refernces -->
[메인]: semi/project_images/main.png
[회원가입]: semi/project_images/signUp.png
[게시글 조회]: semi/project_images/noticeBoard.png
[게시글 상세조회]: semi/project_images/animalDetail.png
[내정보 조회]: semi/project_images/myinfo.png
