package gyakusou.java.management.lms.handler;

import java.sql.Date;
import gyakusou.java.management.lms.domain.Raffle;
import gyakusou.java.management.util.Iterator;
import gyakusou.java.management.util.List;
import gyakusou.java.management.util.Prompt;;

public class RaffleHandler {

	List<Raffle> raffleList;

	public Prompt prompt;

	public RaffleHandler(final Prompt prompt, final List<Raffle> list) {
		this.prompt = prompt;
		this.raffleList = list;
	}

	public void addRaffle() {

		final Raffle raffle = new Raffle();

		raffle.setNo(prompt.inputInt("번호? "));
		raffle.setBrand(prompt.inputString("브랜드명? "));
		raffle.setShoeName(prompt.inputString("신발명? "));
		raffle.setReleaseDate(Date.valueOf(prompt.inputString("출시일? ")));
		raffle.setPrice(prompt.inputInt("가격? "));
		raffle.setPlaceSale(prompt.inputString("발매장소? "));

		raffleList.add(raffle);

		System.out.println("저장하였습니다.");
	}


	public void deleteRaffle() {
		final int index = indexOfRaffle(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("게시물이 유효하지 않습니다.");
			return;
		}

		raffleList.remove(index);

		System.out.println("게시글을 삭제했습니다.");
	}


	public void detailRaffle() {
		final int index = indexOfRaffle(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("게시물 번호가 유효하지 않습니다.");
			return;
		}

		final Raffle raffle = raffleList.get(index);

		System.out.printf("번호: %d\n", raffle.getNo());
		System.out.printf("브랜드명: %s\n", raffle.getBrand());
		System.out.printf("신발명: %s\n", raffle.getShoeName());
		System.out.printf("출시일: %s\n", raffle.getReleaseDate());
		System.out.printf("가격: %s\n", raffle.getPrice());
		System.out.printf("발매장소: %s\n", raffle.getPlaceSale());
	}



	private int indexOfRaffle(final int no) {
		for (int i = 0; i < raffleList.size(); i++) {
			if (raffleList.get(i).getNo() == no) {
				return i;
			}
		}
		return -1;
	}

	public void listRaffle() {
		Iterator<Raffle> iterator = raffleList.iterator();

		while (iterator.hasNext()) {
			Raffle r = iterator.next();

			System.out.printf("%s, %s, %s, %s, %d, %s\n", r.getNo(), r.getBrand(), r.getShoeName(),
					r.getReleaseDate(), r.getPrice(), r.getPlaceSale());
		}
	}

	public void updateRaffle() {
		int index = indexOfRaffle(prompt.inputInt("번호? "));

		if (index == -1) {
			System.out.println("게시물이 유효하지 않습니다.");
			return;
		}

		Raffle oldRaffle = this.raffleList.get(index);
		Raffle newRaffle = new Raffle();

		newRaffle.setNo(oldRaffle.getNo());

		newRaffle.setBrand(prompt.inputString(
				String.format("브랜드명(%s)? ", oldRaffle.getBrand()), 
				oldRaffle.getBrand()));

		newRaffle.setShoeName(prompt.inputString(
				String.format("신발명(%s)? ", oldRaffle.getShoeName()), 
				oldRaffle.getShoeName()));

		newRaffle.setReleaseDate(prompt.inputDate(
				String.format("출시일(%s)? ", oldRaffle.getReleaseDate()), 
				oldRaffle.getReleaseDate()));

		newRaffle.setPrice(prompt.inputInt(
				String.format("가격(%s)? ", oldRaffle.getPrice()), 
				oldRaffle.getPrice()));

		newRaffle.setPlaceSale(prompt.inputString(
				String.format("발매장소(%s)? ", oldRaffle.getPlaceSale()), 
				oldRaffle.getPlaceSale()));

		if (oldRaffle.equals(newRaffle)) {
			System.out.println("변경 취소 하였습니다.");
			return;
		} 
		this.raffleList.set(index, newRaffle);
		System.out.println(" 변경 하였습니다.");
	}

}
