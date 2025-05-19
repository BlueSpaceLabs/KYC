package org.techdisqus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageProvider {
	private Locale defaultLocale = Locale.forLanguageTag("en");

	@Autowired
	private MessageSource messageSource;

	/**
	 * Constructs a MessageProvider which defaults to the Locale for the specified
	 * <a href="https://docs.oracle.com/javase/tutorial/i18n/locale/matching.html">language tag</a>
	 * - for example for Brazilian Portuguese use "pt-BR". Callers can override the default locale
	 * by passing a different Locale argument.
	 *
	 * @param defaultLocaleLanguageTag the language tag for the default locale for this MessageProvider
	 */
	public MessageProvider(String defaultLocaleLanguageTag) {
		this.defaultLocale = Locale.forLanguageTag(defaultLocaleLanguageTag);
	}

	/**
	 * Gets the message in the default locale for the specified code, with no message arguments.
	 *
	 * @param code the message code to look up
	 * @return
	 */
	public String getMessage(String code) {
		return messageSource.getMessage(code, null, defaultLocale);
	}

	/**
	 * Gets one of two messages in the default locale for the specified code, based on the boolean condition.
	 * If the condition evaluates to true, the message corresponding to trueCode will be returned, otherwise
	 * the condition corresponding to falseCode will be returned.
	 *
	 * @param condition If true, the message corresponding to trueCode will be returned, otherwise the condition corresponding to falseCode will be returned.
	 * @param trueCode  The code for the message to return if condition is true.
	 * @param falseCode The code for the message to return if condition is false.
	 * @return The message corresponding to the relevant code.
	 */
	public String getMessage(boolean condition, String trueCode, String falseCode) {
		String code = condition ? trueCode : falseCode;
		return messageSource.getMessage(code, null, defaultLocale);
	}

	/**
	 * Gets the message in the default locale for the specified code, with message arguments.
	 *
	 * @param code the message code to look up
	 * @param args the message arguments
	 * @return
	 */
	public String getMessage(String code, Object... args) {
		return messageSource.getMessage(code, args, defaultLocale);
	}

	/**
	 * Gets the message in the specified locale for the specified code, with no message arguments.
	 *
	 * @param code   the message code to look up
	 * @param locale the locale to use
	 * @return
	 */
	public String getMessage(String code, Locale locale) {
		return messageSource.getMessage(code, null, locale);
	}

	/**
	 * Gets the message in the specified locale for the specified code, with message arguments.
	 *
	 * @param code   the message code to look up
	 * @param args   the message arguments
	 * @param locale the locale to use
	 * @return
	 */
	public String getMessage(String code, Object[] args, Locale locale) {
		return messageSource.getMessage(code, args, locale);
	}
}