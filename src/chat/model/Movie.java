package chat.model;

import java.time.LocalDate;

public class Movie
{
	private String title;
	private String genre;
	private String ratingMPAA;
	private String review;
	private int length;
	private LocalDate releaseDate;
	private double starScore;

	/**
	 * Basic constructor, sets everything to a default value and to desired title.
	 * 
	 * @param title
	 *            The name of the Movie.
	 */
	public Movie(String title)
	{
		if (title.length() > 3)
		{
			this.title = title;
		}
		else
		{
			this.title = "movie";
		}
		this.genre = "generic";
		this.ratingMPAA = "G";
		this.review = "This movie is a movie.";
		this.length = 11;
		this.releaseDate = LocalDate.now();
		this.starScore = 0.0;
	}

	/**
	 * More complex constructor, sets everything to a default value and to desired title and genre.
	 * 
	 * @param title
	 *            The name of the Movie.
	 * @param genre
	 *            The genre of the Movie.
	 */
	public Movie(String title, String genre)
	{
		if (title.length() > 3)
		{
			this.title = title;
		}
		else
		{
			this.title = "movie";
		}
		if (genre.length() > 4)
		{
			this.genre = genre;
		}
		else
		{
			this.genre = "generic";
		}
		this.ratingMPAA = "G";
		this.review = "This movie is a movie.";
		this.length = 11;
		this.releaseDate = LocalDate.now();
		this.starScore = 0.0;
	}

	/**
	 * Complex constructor that takes values for every data member.
	 * 
	 * @param title
	 *            The name of the Movie.
	 * @param genre
	 *            The genre of the Movie.
	 * @param ratingMPAA
	 *            The age rating of the Movie.
	 * @param review
	 *            The review of the Movie.
	 * @param length
	 *            The length of the Movie in minutes.
	 * @param releaseDate
	 *            The release date of the Movie.
	 * @param starScore
	 *            The rating of how good the Movie is.
	 */
	public Movie(String title, String genre, String ratingMPAA, String review, int length, LocalDate releaseDate, double starScore)
	{
		this.title = title;
		this.genre = genre;
		this.ratingMPAA = ratingMPAA;
		this.review = review;
		this.length = length;
		this.releaseDate = releaseDate;
		this.starScore = starScore;
	}

	/**
	 * @return title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * @return genre
	 */
	public String getGenre()
	{
		return genre;
	}

	/**
	 * @return ratingMPAA
	 */
	public String getRatingMPAA()
	{
		return ratingMPAA;
	}

	/**
	 * @return review
	 */
	public String getReview()
	{
		return review;
	}

	/**
	 * @return length
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * @return releaseDate
	 */
	public LocalDate getReleaseDate()
	{
		return releaseDate;
	}

	/**
	 * @return starScore
	 */
	public double getStarScore()
	{
		return starScore;
	}

	/**
	 * @param title new title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * @param genre new genre
	 */
	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	/**
	 * @param ratingMPAA new ratingMPAA
	 */
	public void setRatingMPAA(String ratingMPAA)
	{
		this.ratingMPAA = ratingMPAA;
	}

	/**
	 * @param review new review
	 */
	public void setReview(String review)
	{
		this.review = review;
	}

	/**
	 * @param length new length
	 */
	public void setLength(int length)
	{
		this.length = length;
	}

	/**
	 * @param releaseDate new releaseDate
	 */
	public void setReleaseDate(LocalDate releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	/**
	 * @param starScore new starScore
	 */
	public void setStarScore(double starScore)
	{
		this.starScore = starScore;
	}

	/**
	 * Overrides the standard toString method for more useful output.
	 */
	public String toString()
	{
		return "";
	}
}
