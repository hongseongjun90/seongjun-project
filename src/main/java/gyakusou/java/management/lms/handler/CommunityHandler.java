package gyakusou.java.management.lms.handler;

import gyakusou.java.management.lms.domain.Community;
import gyakusou.java.management.util.Iterator;
import gyakusou.java.management.util.List;
import gyakusou.java.management.util.Prompt;

public class CommunityHandler {

	List<Community> communityList;

	Prompt prompt;

	public CommunityHandler(Prompt prompt, List<Community> list) {
		this.prompt = prompt;
		this.communityList = list;
	}

	public void listCommunity() {

		Iterator<Community> iterator = communityList.iterator();


		while (iterator.hasNext()) {

			Community c = iterator.next();

			System.out.printf("%d, %s, %s, %s, %s, %s\n", 
					c.getNo(), c.getId(), c.getNickName(), c.getTitle() , 
					c.getContents(), c.getBrandtag());
		}
	}

	public void addCommunity() {

		Community community = new Community();

		community.setNo(prompt.inputInt("번호? "));
		community.setId(prompt.inputString("아이디? "));
		community.setNickName(prompt.inputString("닉네임? "));
		community.setTitle(prompt.inputString("제목? "));
		community.setContents(prompt.inputString("내용? "));
		community.setBrandtag(prompt.inputString("브랜드태그? "));

		this.communityList.add(community);

		System.out.println("저장하였습니다.");
	}

	public void detailCommunity() {
		int index = indexOfCommunity(prompt.inputInt("게시물 번호? "));

		if (index == -1) {
			System.out.println("게시물 번호가 유효하지 않습니다.");
			return;
		}

		Community community = this.communityList.get(index);

		System.out.printf("번호: %d\n", community.getNo());
		System.out.printf("아이디: %s\n", community.getId());
		System.out.printf("닉네임: %s\n", community.getNickName());
		System.out.printf("제목: %s\n", community.getTitle());
		System.out.printf("내용: %s\n", community.getContents());
		System.out.printf("브랜드태그: %s\n", community.getBrandtag());
	}

	public void updateCommunity() {
		int index = indexOfCommunity(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("게시물이 유효하지 않습니다.");
			return;
		}

		Community oldCommunity = this.communityList.get(index);
		Community newCommunity = new Community();

		newCommunity.setNo(oldCommunity.getNo());

		newCommunity.setId(prompt.inputString(
				String.format("아이디(%s)? ", oldCommunity.getId()), oldCommunity.getId()));

		newCommunity.setNickName(prompt.inputString(
				String.format("닉네임(%s)? ", oldCommunity.getNickName()), oldCommunity.getNickName()));

		newCommunity.setTitle(prompt.inputString(
				String.format("제목(%s)? ", oldCommunity.getTitle()), oldCommunity.getTitle()));

		newCommunity.setContents(prompt.inputString(
				String.format("내용(%s)? ", oldCommunity.getContents()), oldCommunity.getContents()));

		newCommunity.setBrandtag(prompt.inputString(
				String.format("브랜드태그(%s)? ", oldCommunity.getBrandtag()), oldCommunity.getBrandtag()));

		if (oldCommunity.equals(newCommunity)) {
			System.out.println("변경 취소하였습니다..");
			return;
		} 
		this.communityList.set(index, newCommunity);
		System.out.println("변경하였습니다.");
	}


	public void deleteCommunity() {
		int index = indexOfCommunity(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("게시물이 유효하지 않습니다.");
			return;
		}

		this.communityList.remove(index);

		System.out.println("게시글을 삭제했습니다.");
	}

	private int indexOfCommunity(int no) {
		for (int i = 0; i < this.communityList.size(); i++) {
			if (this.communityList.get(i).getNo() == no) {
				return i;
			}
		}
		return -1;
	}

}



















