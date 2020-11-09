package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.expense.CurrencyFullName;

public class SupportedCurrencyTable extends UiPart<Stage> {
    public static final String URL = "https://currencylayer.com/currencies";
    public static final String MESSAGE = "Please refer to this online website supported by currencylayer.\n"
            + "\n" + URL;
    private static final String FXML = "SupportedCurrencyTable.fxml";

    private TableView<CurrencyFullName> tableView = new TableView<>();
    private final Logger logger = LogsCenter.getLogger(SupportedCurrencyTable.class);

    private TableColumn code = new TableColumn("Currency Code");
    private TableColumn name = new TableColumn("Full Name");

    private ObservableList<CurrencyFullName> list = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    private Label label;

    /**
     * Creates a new SupportedCurrencyTable.
     *
     * @param root Stage to use as the root of the StatisticsWindow.
     */
    public SupportedCurrencyTable(Stage root) {
        super(FXML, root);
        label.setGraphic(tableView);
        label.setMinWidth(350);

        getRoot().addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.Q == event.getCode()) {
                getRoot().hide();
            }
        }
        );
    }

    /**
     * Creates a new SupportedCurrencyTable.
     */
    public SupportedCurrencyTable() {
        this(new Stage());
    }

    /**
     * Constructs the supported currency table.
     */
    public void constructTable() {
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        list.addAll(new CurrencyFullName("AED", "United Arab Emirates Dirham"),
                new CurrencyFullName("AFN", "Afghan Afghani"),
                new CurrencyFullName("ALL", "Albanian Lek"),
                new CurrencyFullName("AMD", "Armenian Dram"),
                new CurrencyFullName("ANG", "Netherlands Antillean Guilder"),
                new CurrencyFullName("AOA", "Angolan Kwanza"),
                new CurrencyFullName("ARS", "Argentine Peso"),
                new CurrencyFullName("AUD", "Australian Dollar"),
                new CurrencyFullName("AWG", "Aruban Florin"),
                new CurrencyFullName("AZN", "Azerbaijani Manat"),
                new CurrencyFullName("BAM", "Bosnia-Herzegovina Convertible Mark"),
                new CurrencyFullName("BBD", "Barbadian Dollar"),
                new CurrencyFullName("BDT", "Bangladeshi Taka"),
                new CurrencyFullName("BGN", "Bulgarian Lev"),
                new CurrencyFullName("BHD", "Bahraini Dinar"),
                new CurrencyFullName("BIF", "Burundian Franc"),
                new CurrencyFullName("BMD", "Bermudan Dollar"),
                new CurrencyFullName("BND", "Brunei Dollar"),
                new CurrencyFullName("BOB", "Bolivian Boliviano"),
                new CurrencyFullName("BRL", "Brazilian Real"),
                new CurrencyFullName("BSD", "Bahamian Dollar"),
                new CurrencyFullName("BTC", "Bitcoin"),
                new CurrencyFullName("BTN", "Bhutanese Ngultrum"),
                new CurrencyFullName("BWP", "Botswanan Pula"),
                new CurrencyFullName("BYN", "Belarusian Ruble"),
                new CurrencyFullName("BYR", "Belarusian Ruble"),
                new CurrencyFullName("BZD", "Belize Dollar"),
                new CurrencyFullName("CAD", "Canadian Dollar"),
                new CurrencyFullName("CDF", "Congolese Franc"),
                new CurrencyFullName("CHF", "Swiss Franc"),
                new CurrencyFullName("CLF", "Chilean Unit of Account (UF)"),
                new CurrencyFullName("CLP", "Chilean Peso"),
                new CurrencyFullName("CNY", "Chinese Yuan"),
                new CurrencyFullName("COP", "Colombian Peso"),
                new CurrencyFullName("CRC", "Costa Rican Colón"),
                new CurrencyFullName("CUC", "Cuban Conertibl Peso"),
                new CurrencyFullName("CUP", "Cuban Pes"),
                new CurrencyFullName("CVE", "Cape Verdean Escudo"),
                new CurrencyFullName("CZK", "Czech Republic Koruna"),
                new CurrencyFullName("DJF", "Djiboutian Franc"),
                new CurrencyFullName("DKK", "Danish Krone"),
                new CurrencyFullName("DOP", "Dominican Peso"),
                new CurrencyFullName("DZD", "Algerian Dinar"),
                new CurrencyFullName("EEK", "Estonian Kroon"),
                new CurrencyFullName("EGP", "Egyptian Pound"),
                new CurrencyFullName("ERN", "Eritrean Nakfa"),
                new CurrencyFullName("ETB", "Ethiopian Birr"),
                new CurrencyFullName("EUR", "Euro"),
                new CurrencyFullName("FJD", "Fijian Dollar"),
                new CurrencyFullName("FKP", "Falkland Islands Pound"),
                new CurrencyFullName("GBP", "British Pound Sterling"),
                new CurrencyFullName("GEL", "Georgian Lari"),
                new CurrencyFullName("GGP", "Guernsey Pound"),
                new CurrencyFullName("GHS", "Ghanaian Cedi"),
                new CurrencyFullName("GIP", "Gibraltar Pound"),
                new CurrencyFullName("GMD", "Gambian Dalasi"),
                new CurrencyFullName("GNF", "Guinean Franc"),
                new CurrencyFullName("GTQ", "Guatemalan Quetzal"),
                new CurrencyFullName("GYD", "Guyanaese Dollar"),
                new CurrencyFullName("HKD", "Hong Kong Dollar"),
                new CurrencyFullName("HNL", "Honduran Lempira"),
                new CurrencyFullName("HRK", "Croatian Kuna"),
                new CurrencyFullName("HTG", "Haitian Gourde"),
                new CurrencyFullName("HUF", "Hungarian Forint"),
                new CurrencyFullName("IDR", "Indonesian Rupiah"),
                new CurrencyFullName("ILS", "Israeli New Sheqel"),
                new CurrencyFullName("IMP", "Manx pound"),
                new CurrencyFullName("INR", "Indian Rupee"),
                new CurrencyFullName("IQD", "Iraqi Dinar"),
                new CurrencyFullName("IRR", "Iranian Rial"),
                new CurrencyFullName("ISK", "Icelandic Króna"),
                new CurrencyFullName("JEP", "Jersey Pound"),
                new CurrencyFullName("JMD", "Jamaican Dollar"),
                new CurrencyFullName("JOD", "Jordanian Dinar"),
                new CurrencyFullName("JPY", "Japanese Yen"),
                new CurrencyFullName("KES", "Kenyan Shilling"),
                new CurrencyFullName("KGS", "Kyrgystani Som"),
                new CurrencyFullName("KHR", "Cambodian Riel"),
                new CurrencyFullName("KMF", "Comorian Franc"),
                new CurrencyFullName("KPW", "North Korean Won"),
                new CurrencyFullName("KRW", "South Korean Won"),
                new CurrencyFullName("KWD", "Kuwaiti Dinar"),
                new CurrencyFullName("KYD", "Cayman Islands Dollar"),
                new CurrencyFullName("KZT", "Kazakhstani Tenge"),
                new CurrencyFullName("LAK", "Laotian Kip"),
                new CurrencyFullName("LBP", "Lebanese Pound"),
                new CurrencyFullName("LKR", "Sri Lankan Rupee"),
                new CurrencyFullName("LRD", "Liberian Dollar"),
                new CurrencyFullName("LSL", "Lesotho Loti"),
                new CurrencyFullName("LTL", "Lithuanian Litas"),
                new CurrencyFullName("LVL", "Latvian Lats"),
                new CurrencyFullName("LYD", "Libyan Dinar"),
                new CurrencyFullName("MAD", "Moroccan Dirham"),
                new CurrencyFullName("MDL", "Moldovan Leu"),
                new CurrencyFullName("MGA", "Malagasy Ariary"),
                new CurrencyFullName("MKD", "Macedonian Denar"),
                new CurrencyFullName("MMK", "Myanma Kyat"),
                new CurrencyFullName("MNT", "Mongolian Tugrik"),
                new CurrencyFullName("MOP", "Macanese Pataca"),
                new CurrencyFullName("MRO", "Mauritanian Ouguiya"),
                new CurrencyFullName("MUR", "Mauritian Rupee"),
                new CurrencyFullName("MVR", "Maldivian Rufiyaa"),
                new CurrencyFullName("MWK", "Malawian Kwacha"),
                new CurrencyFullName("MXN", "Mexican Peso"),
                new CurrencyFullName("MYR", "Malaysian Ringgit"),
                new CurrencyFullName("MZN", "Mozambican Metical"),
                new CurrencyFullName("NAD", "Namibian Dollar"),
                new CurrencyFullName("NGN", "Nigerian Naira"),
                new CurrencyFullName("NIO", "Nicaraguan Córdoba"),
                new CurrencyFullName("NOK", "Norwegian Krone"),
                new CurrencyFullName("NPR", "Nepalese Rupee"),
                new CurrencyFullName("NZD", "New Zealand Dollar"),
                new CurrencyFullName("OMR", "Omani Rial"),
                new CurrencyFullName("PAB", "Panamanian Balboa"),
                new CurrencyFullName("PEN", "Peruvian Nuevo Sol"),
                new CurrencyFullName("PGK", "Papua New Guinean Kina"),
                new CurrencyFullName("PHP", "Philippine Peso"),
                new CurrencyFullName("PKR", "Pakistani Rupee"),
                new CurrencyFullName("PLN", "Polish Zloty"),
                new CurrencyFullName("PYG", "Paraguayan Guarani"),
                new CurrencyFullName("QAR", "Qatari Rial"),
                new CurrencyFullName("RON", "Romanian Leu"),
                new CurrencyFullName("RSD", "Serbian Dinar"),
                new CurrencyFullName("RUB", "Russian Ruble"),
                new CurrencyFullName("RWF", "Rwandan Franc"),
                new CurrencyFullName("SAR", "Saudi Riyal"),
                new CurrencyFullName("SBD", "Solomon Islands Dollar"),
                new CurrencyFullName("SCR", "Seychellois Rupee"),
                new CurrencyFullName("SDG", "Sudanese Pound"),
                new CurrencyFullName("SEK", "Swedish Krona"),
                new CurrencyFullName("SGD", "Singapore Dollar"),
                new CurrencyFullName("SHP", "Saint Helena Pound"),
                new CurrencyFullName("SLL", "Sierra Leonean Leone"),
                new CurrencyFullName("SOS", "Somali Shilling"),
                new CurrencyFullName("SRD", "Surinamese Dollar"),
                new CurrencyFullName("STD", "São Tomé and Príncipe Dobra"),
                new CurrencyFullName("SVC", "Salvadoran Colón"),
                new CurrencyFullName("SYP", "Syrian Pound"),
                new CurrencyFullName("SZL", "Swazi Lilangeni"),
                new CurrencyFullName("THB", "Thai Baht"),
                new CurrencyFullName("TJS", "Tajikistani Somoni"),
                new CurrencyFullName("TMT", "Turkmenistani Manat"),
                new CurrencyFullName("TND", "Tunisian Dinar"),
                new CurrencyFullName("TOP", "Tongan Paʻanga"),
                new CurrencyFullName("TRY", "Turkish Lira"),
                new CurrencyFullName("TTD", "Trinidad and Tobago Dollar"),
                new CurrencyFullName("TWD", "New Taiwan Dollar"),
                new CurrencyFullName("TZS", "Tanzanian Shilling"),
                new CurrencyFullName("UAH", "Ukrainian Hryvnia"),
                new CurrencyFullName("UGX", "Ugandan Shilling"),
                new CurrencyFullName("USD", "United States Dollar"),
                new CurrencyFullName("UYU", "Uruguayan Peso"),
                new CurrencyFullName("UZS", "Uzbekistan Som"),
                new CurrencyFullName("VEF", "Venezuelan Bolívar Fuerte"),
                new CurrencyFullName("VND", "Vietnamese Dong"),
                new CurrencyFullName("VUV", "Vanuatu Vatu"),
                new CurrencyFullName("WST", "Samoan Tala"),
                new CurrencyFullName("XAF", "CFA Franc BEAC"),
                new CurrencyFullName("XAG", "Silver (troy ounce)"),
                new CurrencyFullName("XAU", "Gold (troy ounce)"),
                new CurrencyFullName("XCD", "East Caribbean Dollar"),
                new CurrencyFullName("XDR", "Special Drawing Rights"),
                new CurrencyFullName("XOF", "CFA Franc BCEAO"),
                new CurrencyFullName("XPF", "CFP Franc"),
                new CurrencyFullName("YER", "Yemeni Rial"),
                new CurrencyFullName("ZAR", "South African Rand"),
                new CurrencyFullName("ZMK", "Zambian Kwacha (pre-2013)"),
                new CurrencyFullName("ZMW", "Zambian Kwacha"),
                new CurrencyFullName("ZWL", "Zimbabwean Dollar"));
        tableView.setItems(list);
        tableView.getColumns().addAll(code, name);
    }

    /**
     * Shows the currency exchange rate table window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        constructTable();
        logger.fine("Showing command currency exchange rates!");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(URL);
        clipboard.setContent(url);
    }

}
